package view.utilities;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import view.constants.FontConstants;

public class RoundedJTextField extends JTextField {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int LATERAL_MARGINS = 10;
    private static final int MARGINS = 0;
    private static final int RADIO_CORNER = 20;

    public RoundedJTextField() {
        super();
        configurarTextField();
    }

    public RoundedJTextField(String texto) {
        super(texto);
        configurarTextField();
    }

    private void configurarTextField() {
        setOpaque(false);
        setBackground(Color.WHITE);
        setForeground(Color.DARK_GRAY);
        setMargin(new Insets(MARGINS, MARGINS, MARGINS, MARGINS));
        setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
        setBorder(new EmptyBorder(MARGINS, LATERAL_MARGINS, MARGINS, LATERAL_MARGINS));
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
        g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

        int x = LATERAL_MARGINS;
        int y = MARGINS;
        int width = getWidth() - (LATERAL_MARGINS * 2);
        int height = getHeight() - (MARGINS * 2);

        Shape forma = new RoundRectangle2D.Double(x, y, width, height, RADIO_CORNER, RADIO_CORNER);
        g2.setColor(getBackground());
        g2.fill(forma);

        super.paintComponent(g);
        g2.dispose();
    }
}

