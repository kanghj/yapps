Ext.define('UserManager.model.Permission', {
    extend: 'Ext.data.Model',
    idProperty:'permissionID',
    fields: ['permissionID', 'permissionCode', 'name', 'description', 'menuID', 'status',
        {name:'createTime', type:'date', dateFormat:'time'},{name:'updateTime', type:'date', dateFormat:'time'}]
});