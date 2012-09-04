Ext.define('FrameLayout.view.MenuList', {
    extend:'Ext.tree.Panel',
    alias:'widget.menulist',

    requires:['Ext.toolbar.Toolbar'],

    title:'Menus',
    collapsible:true,
    animCollapse:true,
    layout:'fit',
    rootVisible:false,
    initComponent:function () {
        this.store = {
            root:{
                expanded:true,
                children:[
                    { text:"detention", leaf:true, id:'id1'},
                    { text:"homework", expanded:true, id:'id2',
                        children:[
                            { text:"book report", leaf:true, id:'id3'},
                            { text:"alegrbra", leaf:true, id:'id4'}
                        ] },
                    { text:"buy lottery tickets", leaf:true, id:'id5'} ,
                    { text:"detention", leaf:true, id:'id11'},
                    { text:"homework", expanded:true, id:'id12',
                        children:[
                            { text:"book report", leaf:true, id:'id13'},
                            { text:"alegrbra", leaf:true, id:'id14'}
                        ] },
                    { text:"buy lottery tickets", leaf:true, id:'1id5'},
                    { text:"detention", leaf:true, id:'id111'},
                    { text:"homework", expanded:true, id:'id112',
                        children:[
                            { text:"book report", leaf:true, id:'id113'},
                            { text:"alegrbra", leaf:true, id:'id114'}
                        ] },
                    { text:"buy lottery tickets", leaf:true, id:'11id5'}

                ]
            }
        }

        this.callParent(arguments);
    }
});
