Ext.define('FrameLayout.controller.MainFrame', {
    requires:['Ext.ux.IFrame'],
    extend: 'Ext.app.Controller',
    views: ['MenuList', 'PageTab'],
    init: function() {
        this.control({
            'menulist': {
                itemdblclick: this.newTab
            }
        });
    },
    newTab: function(view,record,item,index,e,options) {
        var tabs = Ext.getCmp('frame-layout-page-tabs');
        //获取当前点击的节点
        var treeNode=record.raw;
        var id = treeNode.id;
        var text=treeNode.text;
        //获取点击的树节点相同的tab标签
        var tab = tabs.getComponent(id);
        if(!tab){//如果不存在
            if(tabs.items.getCount() >= 20){
                Ext.MessageBox.show({
                    msg: '已达到显示菜单最大限制数',
                    icon: Ext.MessageBox.ERROR,
                    buttons: Ext.Msg.OK
                });
                return;
            }
            tabs.add({
                xtype:'uxiframe',
                title: text,
                src:'/demo/apps/user-manager.jsp',
                closable:true,
                id:id,
                itemId: id
            }).show();
           // tabs.setActiveTab(tabs.getComponent(id));
        }else{//如果存在
            tabs.setActiveTab(tab)//Active
        }
    }
});