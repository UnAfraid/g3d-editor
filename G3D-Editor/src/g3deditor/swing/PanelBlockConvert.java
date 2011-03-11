package g3deditor.swing;

import g3deditor.geo.GeoCell;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public final class PanelBlockConvert extends JPanel implements ActionListener
{
	private final JButton _buttonConvertFlat;
	private final JButton _buttonConvertComplex;
	private final JButton _buttonConvertMultiLayer;
	private final JButton _buttonRestoreBlock;
	
	public PanelBlockConvert()
	{
		_buttonConvertFlat = new JButton("Flat");
		_buttonConvertFlat.addActionListener(this);
		_buttonConvertFlat.setEnabled(false);
		_buttonConvertComplex = new JButton("Complex");
		_buttonConvertComplex.addActionListener(this);
		_buttonConvertComplex.setEnabled(false);
		_buttonConvertMultiLayer = new JButton("Multi");
		_buttonConvertMultiLayer.addActionListener(this);
		_buttonConvertMultiLayer.setEnabled(false);
		_buttonRestoreBlock = new JButton("Restore from base");
		_buttonRestoreBlock.addActionListener(this);
		_buttonRestoreBlock.setEnabled(false);
		
		initLayout();
	}
	
	private final void initLayout()
	{
		final GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		setBorder(BorderFactory.createTitledBorder("Block Convert"));
		setLayout(new GridBagLayout());
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		add(_buttonConvertFlat, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		add(_buttonConvertComplex, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		add(_buttonConvertMultiLayer, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 0;
		add(_buttonRestoreBlock, gbc);
	}
	
	private final void setFieldsEnabled(final boolean enabled)
	{
		_buttonConvertFlat.setEnabled(enabled);
		_buttonConvertComplex.setEnabled(enabled);
		_buttonConvertMultiLayer.setEnabled(enabled);
		_buttonRestoreBlock.setEnabled(enabled);
	}
	
	public final void onSelectedCellUpdated()
	{
		final GeoCell cell = FrameMain.getInstance().getSelectedGeoCell();
		if (cell == null)
		{
			setFieldsEnabled(false);
		}
		else
		{
			setFieldsEnabled(true);
		}
	}
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public final void actionPerformed(final ActionEvent e)
	{
		if (e.getSource() == _buttonConvertFlat)
		{
			
		}
		else if (e.getSource() == _buttonConvertComplex)
		{
			
		}
		else if (e.getSource() == _buttonConvertMultiLayer)
		{
			
		}
		else if (e.getSource() == _buttonRestoreBlock)
		{
			
		}
	}
}