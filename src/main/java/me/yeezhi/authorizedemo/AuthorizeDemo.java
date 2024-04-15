package me.yeezhi.authorizedemo;

import me.qingshou.lib.SimpleLib;
import me.qingshou.lib.anntation.Outsource;
import org.bukkit.plugin.java.JavaPlugin;

public final class AuthorizeDemo extends JavaPlugin {
    // 需要混淆的方法加上该注解
    @Outsource
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();

        SimpleLib.getAuthorizeManage().register(this, "25ae4dbe98b19fd6ae", getConfig().getString("config.code"), () -> {
            // Runnable 内写插件授权成功后执行的代码
            getLogger().info("插件正在初始化");
        });
    }

    @Outsource
    public void onDisable() {

    }
}
