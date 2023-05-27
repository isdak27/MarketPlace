package view.body;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.constants.TextConstants;

public class BodyPanel extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private MenuPanel menuPanel;
    private JPanel centralPanel;
    private InvoicePanel invoicePanel;
    private ClientPanel clientPanel;
    private StockPanel stockPanel;

    public BodyPanel() {
        this.initComponents();
    }

    public void initComponents() {
        this.setLayout(new BorderLayout());

        menuPanel = new MenuPanel();
        this.add(menuPanel, BorderLayout.WEST);

        centralPanel = new JPanel(new CardLayout());

        invoicePanel = new InvoicePanel();
        centralPanel.add(invoicePanel, TextConstants.INVOICE_PANEL_ID);

        clientPanel = new ClientPanel();
        centralPanel.add(clientPanel, TextConstants.CLIENT_PANEL_ID);

        stockPanel = new StockPanel();
        centralPanel.add(stockPanel, TextConstants.STOCK_PANEL_ID);

        this.add(centralPanel, BorderLayout.CENTER);

        menuPanel.getInvoiceButton().addActionListener(this);
        menuPanel.getClientButton().addActionListener(this);
        menuPanel.getStockButton().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuPanel.getInvoiceButton()) {
            CardLayout layout = (CardLayout) centralPanel.getLayout();
            layout.show(centralPanel, TextConstants.INVOICE_PANEL_ID);
        } else if (e.getSource() == menuPanel.getClientButton()) {
            CardLayout layout = (CardLayout) centralPanel.getLayout();
            layout.show(centralPanel, TextConstants.CLIENT_PANEL_ID);
        } else if (e.getSource() == menuPanel.getStockButton()) {
            CardLayout layout = (CardLayout) centralPanel.getLayout();
            layout.show(centralPanel, TextConstants.STOCK_PANEL_ID);
        }

    }
}
