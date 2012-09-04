Ext.Loader.setConfig({ enabled: true });
Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'FrameLayout',
    paths: {
        'Ext.ux': '../extjs/ux/'
    },
    appFolder: 'frame-layout',
    controllers: [
        'MainFrame'
    ],
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'border',
            items: [{
                region: 'west',
                width: 225,
                xtype: 'menulist'
            },{
                region: 'center',
                xtype: 'pagetab',
                id:'frame-layout-page-tabs'
            }]
        });
    }
});
