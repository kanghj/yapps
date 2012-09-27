Ext.Loader.setConfig({ enabled: true });
Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'UserManager',
    appFolder: 'user-manager',
    controllers: [
        'Permissions'
    ],
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout:'vbox',
            items: [
                {
                    xtype: 'form',
                    bodyStyle:'padding:5px 5px 0 10px',
                    title:'权限搜索',
                    layout:'table',
                    height: 60,
                    width:'100%',
                    items: [
                        {
                            xtype: 'textfield',
                            name : 'code',
                            fieldLabel: '权限编码',
                            labelAlign:'right'
                        },
                        {
                            xtype: 'textfield',
                            name : 'name',
                            fieldLabel: '权限名称',
                            labelAlign:'right'
                        } ,
                        {
                            xtype: 'textfield',
                            name : 'desc',
                            fieldLabel: '权限描述',
                            labelAlign:'right'
                        }
                    ]
                },
                {
                    xtype: 'permissionlist',
                    width:'100%',
                    flex:1
                }
            ]
        });
    }
});
