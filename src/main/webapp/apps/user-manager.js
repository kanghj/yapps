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
            layout: 'fit',
            items: [
                {
                    xtype: 'userlist',
                    title: 'Users'
                }
            ]
        });
    }
});
