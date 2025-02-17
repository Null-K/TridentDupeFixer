修复 TridentDupe 漏洞，适用于 1.13+ 所有服务端。
漏洞相关链接：https://github.com/Killetx/TridentDupe


This plugin is compatible with all server types. If you are using Paper or any of its forks, you can utilize the simpler code provided below (source: https://github.com/MrXiaoM/BanClickWhenUsingItem/tree/main).
```java
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        HumanEntity entity = e.getWhoClicked();
        ItemStack item = entity.getActiveItem();
        if (item != null && !item.getType().equals(Material.AIR)) {
            // entity.sendMessage("fixed exploit: " + item.getType().name());
            e.setCancelled(true);
        }
    }
