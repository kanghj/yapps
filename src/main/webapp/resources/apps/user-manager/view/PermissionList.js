Ext.define('UserManager.view.PermissionList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.permissionlist',
    title : '权限列表',
    loadMask: true,
    columnLines: true,
    sortable: false,
    initComponent: function() {
        this.store = 'Permissions';
        this.columns = [
            {dataIndex: 'permissionID', hidden:true},
            {header: '权限编码',  dataIndex: 'permissionCode', width: 140},
            {header: '权限名称', dataIndex: 'name', width:160},
            {header: '权限描述', dataIndex: 'description', width:240},
            {header: '菜单ID', dataIndex: 'menuID', width:180},
            {header: '状态', dataIndex: 'status', width:50, xtype:'booleancolumn', trueText: '正常', falseText: '暂停'  },
            {header: '创建时间',renderer : Ext.util.Format.dateRenderer('Y-m-d H:i:s'), dataIndex: 'createTime', width:140},
            {header: '最近更新',renderer : Ext.util.Format.dateRenderer('Y-m-d H:i:s'), dataIndex: 'updateTime',width:140},
            {header:'操作',xtype:'actioncolumn',width:80,
                items:[
                    {
                        iconCls: 'icon-pencil',
                        tooltip: '编辑权限',
                        handler: function(grid, rowIndex, colIndex) {
                            var rec = grid.getStore().getAt(rowIndex);
                            alert("Edit Permission - Code:" + rec.get('permissionCode'));
                        }
                    },
                    {
                        iconCls: 'icon-delete',
                        tooltip: '删除权限',
                        handler: function(grid, rowIndex, colIndex) {
                            var rec = grid.getStore().getAt(rowIndex);
                            grid.getStore().remove(rec);
                        }
                    }
                ]
            }
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
                    text:'增加信息',
                    iconCls:'icon-add',
                    handler:function () {
                        /*rowEditing.cancelEdit();
                         var panelStore = this.up("panel").getStore();
                         var panelModel = this.up("panel").getSelectionModel();
                         panelStore.insert(0, panelModel);
                         rowEditing.startEdit(0, 0);*/
                    }
                }/*,
                '-',
                {
                    itemId:'delete',
                    text:'删除信息',
                    iconCls:'icon-delete',
                    disabled:true,
                    handler:function () {
                         var selection = panel.getView().getSelectionModel().getSelection()[0];
                         var panelStore = this.up("panel").getStore();
                         if (selection) {
                         panelStore.remove(selection);
                         }
                    }
                },
                '-' ,
                {
                    text:'刷新数据',
                    iconCls:'icon-table_refresh',
                    handler:function () {
                        *//*  var panelStore = this.up("panel").getStore();
                         var currPage = panelStore.currentPage;
                         panelStore.removeAll();
                         panelStore.load(currPage);*//*
                    }
                }*/
            ]
        }]
});
