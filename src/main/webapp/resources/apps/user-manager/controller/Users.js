Ext.define('UserManager.controller.Users', {
    extend: 'Ext.app.Controller',
    models: ['User'],
    stores: ['Users'],
    views: ['UserList','UserEdit'],
    init: function() {
        this.control({
            'viewport > panel': {
                render: this.onPanelRendered
            } ,
            'userlist': {
                itemdblclick: this.editUser
            },
            'useredit button[action=save]': {
                click: this.updateUser
            }
        });
    },

    onPanelRendered: function() {
    } ,

    editUser: function(grid, record) {
        var view = Ext.widget('useredit');
        view.down('form').loadRecord(record);
    } ,
    updateUser: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        record.set(values);
        win.close();
        this.getUsersStore().sync();
    }
});