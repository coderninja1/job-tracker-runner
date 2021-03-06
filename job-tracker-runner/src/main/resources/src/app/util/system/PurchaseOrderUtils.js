/**
 * The <class>System.util.system.PurchaseOrderUtils</class> defines
 *  utility methods for working with Purchase Order UI components.
 *
 * @author Andrew
 */
Ext.define('System.util.system.PurchaseOrderUtils', {

    requires: ['System.view.system.window.SchemaTabGridSystemWindow'],

    ///////////////////////////////////////////////////////////////////////
    ////////                                                         Methods                                                      //////////
    /////////////////////////////////////////////////////////////////////

    statics: {
        /**
         * Create the Purchase Order windows
         */
        createJobSchemaTabGridSystemWindow: function () {
            var win = Ext.create("System.view.purchaseOrder.PurchaseOrderWindow", {});
            win.show();
        },
        createWindow: function (windowPath) {
            var win = Ext.create(windowPath, {});
            win.show();
        }

    }
});
