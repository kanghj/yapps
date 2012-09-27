Ext.define('UserManager.controller.Permissions', {
    extend: 'Ext.app.Controller',
    models: ['Permission'],
    stores: ['Permissions'],
    views: ['PermissionList'],
    init: function() {
        this.control({
            'viewport > panel': {
                render: this.onPanelRendered
            }
        });
    },

    onPanelRendered: function() {
    }
});