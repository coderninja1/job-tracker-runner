/**
 * The <class>System.view.project.PurchaseOrderWindow</class> defines the main
 * job.tracker Purchase Order Window.
 *
 * @author Andrew
 */
Ext.define('System.view.purchaseOrder.PurchaseOrderWindow', {
    extend: 'System.view.component.window.tab.grid.TabGridSystemWindow',

    title: 'Purchase Order Management',

    constructor: function (config) {
        var me = config;

        me.tabs = [
            {
                title: 'Purchase Orders',
                modelName: 'PurchaseOrders'
            }
        ];

        this.callParent([config]);
    }

});
