Ext.define('UserManager.model.User', {
    extend: 'Ext.data.Model',
    fields: ['userID', 'loginName', 'password', 'userName','mobile', 'email','lastLoginTime','failLoginCount', 'status', 'createTime', 'updateTime']
});