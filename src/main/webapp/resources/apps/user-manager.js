Ext.Loader.setConfig({ enabled: true });
Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'UserManager',
    appFolder: 'user-manager',
    controllers: [
        'Users'
    ],
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout:'vbox',
            items: [
                {
                    xtype: 'form',
                    bodyStyle:'padding:5px 5px 0 10px',
                    title:'用户搜索',
                    layout:'table',
                    height: 60,
                    width:'100%',
                    items: [
                        {
                            xtype: 'textfield',
                            name : 'name',
                            fieldLabel: '登录帐号',
                            labelAlign:'right'
                        },
                        {
                            xtype: 'textfield',
                            name : 'email',
                            fieldLabel: '姓名',
                            labelAlign:'right'
                        }
                    ]
                },
                {
                    xtype: 'userlist',
                    width:'100%',
                    flex:1
                }
            ]
        });
    }
});
