Ext.define('FrameLayout.view.PageTab', {
    extend:'Ext.tab.Panel',
    alias:'widget.pagetab',
    requires: ['Ext.ux.TabScrollerMenu','Ext.ux.TabCloseMenu','Ext.ux.TabReorderer'],
    layout:'fit',
    animScroll : true,//使用动画滚动效果
    enableTabScroll: false,              //选项卡过多时，允许滚动
    plugins: [{
        ptype: 'tabscrollermenu',
        maxText  : 15,
        pageSize : 5
    },{
        ptype:'tabclosemenu',
        extraItemsTail: [
            '-',
            {
                text: 'Closable',
                checked: true,
                hideOnClick: true,
                handler: function (item) {
                    currentItem.tab.setClosable(item.checked);
                }
            }
        ],
        listeners: {
            aftermenu: function () {
                currentItem = null;
            },
            beforemenu: function (menu, item) {
                var menuitem = menu.child('*[text="Closable"]');
                currentItem = item;
                menuitem.setChecked(item.closable);
            }
        }
    },Ext.create('Ext.ux.TabReorderer')],
    items: []
});
