Ext.define('FrameLayout.view.MenuList', {
    extend:'Ext.tree.Panel',
    alias:'widget.menulist',

    requires:['Ext.toolbar.Toolbar'],

    title:'功能菜单',
    collapsible:true,
    animCollapse:true,
    layout:'fit',
    rootVisible:false,
    initComponent:function () {
        this.store = {
            root:{
                expanded:true,
                children:[
                    { text:"系统管理", expanded:true, id:'id1',
                        children:[
                            { text:"用户管理",url:"user-manager.html" ,leaf:true, id:'id2'},
                            { text:"角色管理", leaf:true, id:'id3'},
                            { text:"权限管理",url:"permission-manager.html" , leaf:true, id:'id4'},
                            { text:"组织管理", leaf:true, id:'id5'},
                            { text:"菜单管理", leaf:true, id:'id6'},
                            { text:"系统设置", leaf:true, id:'id7'},
                            { text:"查看日志", leaf:true, id:'id8'}
                        ] },
                    { text:"统计报表", expanded:true, id:'id10',
                        children:[
                            { text:"销售表报", leaf:true, id:'id11'},
                            { text:"库存图表", leaf:true, id:'id12'},
                            { text:"绩效统计", leaf:true, id:'id13'}
                        ] }
                ]
            }
        };

        this.callParent(arguments);
    }
});
