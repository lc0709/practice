package com.doiche.utils;

import com.doiche.Main;
import org.bukkit.scheduler.BukkitScheduler;
import java.util.HashMap;
import java.util.Map;

public class Scheduler {
    private static final Main plugin = Main.inst();
    private static final BukkitScheduler scheduler =  plugin.getServer().getScheduler();

    private Scheduler() {
        throw new UnsupportedOperationException("inst 금지");
    }

    public static void sync(Runnable run){
        scheduler.runTask(plugin, run);
    }
    public static void async(Runnable run){
        scheduler.runTaskAsynchronously(plugin, run);
    }

    public static void sync(long delay, Runnable run){
        scheduler.runTaskLater(plugin, run, delay);
    }
    public static void async(long delay, Runnable run){
        scheduler.runTaskLaterAsynchronously(plugin, run, delay);
    }

    public static void syncLoop(long period, Runnable run){
        scheduler.runTaskTimer(plugin, run, TimeUtil.ZERO, TimeUtil.seconds(period));
    }
    public static void asyncLoop(long period, Runnable run){
        scheduler.runTaskTimerAsynchronously(plugin, run, TimeUtil.ZERO, TimeUtil.seconds(period));
    }

    /**
         * offers a locked async tasks.
         */
    record PersonalScheduler<T>(T runner) {
        private static final Map<String, Boolean> taskLocks = new HashMap<>();

        public void async(String taskName, Runnable run) {
            if (isLockedOrCreate(taskName)) {
                lock(taskName);
                scheduler.runTaskAsynchronously(plugin, run);
                unLock(taskName);
            }
        }

        public void async(String taskName, long delay, Runnable run) {
            if (isLockedOrCreate(taskName)) {
                lock(taskName);
                scheduler.runTaskLaterAsynchronously(plugin, run, delay);
                unLock(taskName);
            }
        }

        public void asyncLoop(String taskName, long period, Runnable run) {
            if (isLockedOrCreate(taskName)) {
                lock(taskName);
                scheduler.runTaskTimerAsynchronously(plugin, run, TimeUtil.ZERO, TimeUtil.seconds(period));
                unLock(taskName);
            }
        }

        private boolean isLockedOrCreate(String name) {
            if (taskLocks.containsKey(name)) {
                return taskLocks.get(name);
            } else {
                taskLocks.put(name, true);
                return true;
            }
        }

        private void lock(String name) {
            taskLocks.put(name, true);
        }
        private void unLock(String name) {
            taskLocks.put(name, false);
        }
    }
}
