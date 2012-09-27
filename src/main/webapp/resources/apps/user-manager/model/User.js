Ext.define('UserManager.model.User', {
    extend: 'Ext.data.Model',
    fields: ['userID', 'loginName', 'password', 'userName','mobile', 'email',
        {name:'lastLoginTime', type:'date', dateFormat:'time'},'failLoginCount', 'status',
        {name:'createTime', type:'date', dateFormat:'time'},
        {name:'updateTime', type:'date', dateFormat:'time'}]
});