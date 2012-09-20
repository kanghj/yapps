Ext.define('UserManager.view.UserList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',
    title : '用户列表',
    loadMask: true,
    columnLines: true,
    initComponent: function() {
        this.store = 'Users';
        this.columns = [
            {dataIndex: 'userID', hidden:true},
            {header: '登录账户',  dataIndex: 'loginName', width: 140},
            {header: '姓名', dataIndex: 'userName', width:60},
            {header: '联系方式', dataIndex: 'mobile', width:140},
            {header: '电子邮箱', dataIndex: 'email', width:180},
            {header: '最近登录时间', dataIndex: 'lastLoginTime',width:140},
            {header: '登录失败次数', dataIndex: 'failLoginCount', width:80},
            {header: '状态', dataIndex: 'status', width:50, xtype:'booleancolumn', trueText: '正常', falseText: '暂停'  },
            {header: '创建时间', dataIndex: 'createTime', width:140},
            {header: '最近更新', dataIndex: 'updateTime',width:140}
        ];
        // paging bar on the bottom
        this.bbar = Ext.create('Ext.PagingToolbar', {
            store: this.store,
            pageSize: 20,
            displayInfo: true
        });
        this.callParent(arguments);
    },

    dockedItems: [
        {
        xtype: 'toolbar',
        items: [
            {
                text : '新增',
                iconCls : 'icon-add'
            }, {
                text : '修改',
                iconCls : 'icon-pencil'
            }, {
                text : '删除',
                iconCls : 'icon-delete'
            }, '-', {
                text : '导出PDF',
                iconCls : 'icon-page_white_acrobat'
            }, {
                text : '导出Excel',
                iconCls : 'icon-page_white_excel'
            }, '-', {
                text : '打印',
                iconCls : 'icon-printer'
            }
       ]
    },

        {
        xtype: 'toolbar',
        items: [
            {
                text:'增加信息',
                iconCls:'icon-add',
                handler:function () {
                    /*rowEditing.cancelEdit();
                    var panelStore = this.up("panel").getStore();
                    var panelModel = this.up("panel").getSelectionModel();
                    panelStore.insert(0, panelModel);
                    rowEditing.startEdit(0, 0);*/
                }
            },
            '-',
            {
                itemId:'delete',
                text:'删除信息',
                iconCls:'icon-delete',
                disabled:true,
                handler:function () {
                   /* var selection = panel.getView().getSelectionModel().getSelection()[0];
                    var panelStore = this.up("panel").getStore();
                    if (selection) {
                        panelStore.remove(selection);
                    }*/
                }
            },
            '-' ,
            {
                text:'刷新数据',
                iconCls:'icon-table_refresh',
                handler:function () {
                  /*  var panelStore = this.up("panel").getStore();
                    var currPage = panelStore.currentPage;
                    panelStore.removeAll();
                    panelStore.load(currPage);*/
                }
            }
        ]
    }]
});
