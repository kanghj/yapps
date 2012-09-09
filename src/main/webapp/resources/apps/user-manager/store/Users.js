Ext.define('UserManager.store.Users', {
    extend: 'Ext.data.Store',
    model: 'UserManager.model.User',
    autoLoad: true,
    proxy:{
        type: 'ajax',
        api: {
            read: '../../manager/user/search.do',
            update: 'data/updateUsers.json'
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
            writeAllFields: false,
            root: 'data'
        },
        listeners: {
            exception: function(proxy, response, operation){
                Ext.MessageBox.show({
                    title: 'REMOTE EXCEPTION',
                    msg: operation.getError(),
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