Ext.define('UserManager.store.Permissions', {
    extend: 'Ext.data.Store',
    model: 'UserManager.model.Permission',
    autoLoad: true,
    autoSync: true,
    proxy:{
        type: 'ajax',
        api: {
            create: 'myurl',
            read: '../../manager/permission/search.do',
            update: 'data/updateUsers.json',
            destroy : '../../manager/permission/delete.do'
        },
        reader: {
            type: 'json',
            successProperty: 'success',
            messageProperty: 'message',
            root: 'data',
            totalProperty: 'total'
        },
        writer: {
            type: 'json',
            writeAllFields: false/*,
            root: 'data'*/
        },
        listeners: {
            exception: function(proxy, response, operation){
                if(operation.action=='destroy'){
                    Ext.getStore('Permissions').rejectChanges();
                }
                var error = operation.getError();
                if(error.status){
                    error = error.status + ' ' + error.statusText;
                }
                Ext.MessageBox.show({
                    title: '错误信息！',
                    msg: error,
                    icon: Ext.MessageBox.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        }
    },
    listeners: {
        write: function(proxy, operation){
            alert(operation.action);
            /*if (operation.action == 'destroy') {
             main.child('#form').setActiveRecord(null);
             }
             Ext.example.msg(operation.action, operation.resultSet.message);*/
        }
    }
});