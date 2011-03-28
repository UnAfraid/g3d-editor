/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package g3deditor.entity;

import g3deditor.Config;
import g3deditor.geo.GeoBlock;
import g3deditor.geo.GeoCell;
import g3deditor.geo.GeoEngine;
import g3deditor.jogl.GLColor;
import g3deditor.jogl.GLDisplay;
import g3deditor.swing.FrameMain;

import java.awt.Color;

/**
 * <a href="http://l2j-server.com/">L2jServer</a>
 * 
 * @author Forsaiken aka Patrick, e-mail: patrickbiesenbach@yahoo.de
 */
public enum SelectionState
{
	NORMAL		(Config.COLOR_FLAT_NORMAL, Config.COLOR_COMPLEX_NORMAL, Config.COLOR_MULTILAYER_NORMAL),
	HIGHLIGHTED	(Config.COLOR_FLAT_HIGHLIGHTED, Config.COLOR_COMPLEX_HIGHLIGHTED, Config.COLOR_MULTILAYER_HIGHLIGHTED),
	SELECTED	(Config.COLOR_FLAT_SELECTED, Config.COLOR_COMPLEX_SELECTED, Config.COLOR_MULTILAYER_SELECTED);
	
	public static final float ALPHA = 0.7f;
	
	private final GLColor _colorGuiSelected;
	private final GLColor _colorFlat;
	private final GLColor _colorComplex1;
	private final GLColor _colorComplex2;
	private final GLColor _colorMutliLayer1a;
	private final GLColor _colorMutliLayer2a;
	private final GLColor _colorMutliLayer1b;
	private final GLColor _colorMutliLayer2b;
	
	private SelectionState(final int colorFlat, final int colorComplex, final int colorMutliLayer)
	{
		_colorGuiSelected = new GLColor(Color.YELLOW, ALPHA);
		_colorFlat = new GLColor(new Color(colorFlat), ALPHA);
		_colorComplex1 = new GLColor(new Color(colorComplex), ALPHA);
		_colorComplex2 = new GLColor(_colorComplex1, 0.85f, 0.85f, 0.85f);
		_colorMutliLayer1a = new GLColor(new Color(colorMutliLayer), ALPHA);
		_colorMutliLayer2a = new GLColor(_colorMutliLayer1a, 0.85f, 0.85f, 0.85f);
		_colorMutliLayer1b = new GLColor(_colorMutliLayer1a.getR() + 0.5f, _colorMutliLayer1a.getG() + 0.5f, _colorMutliLayer1a.getB() + 0.5f, ALPHA);
		_colorMutliLayer2b = new GLColor(_colorMutliLayer2a.getR() + 0.5f,_colorMutliLayer2a.getG() + 0.5f, _colorMutliLayer2a.getB() + 0.5f, ALPHA);
	}
	
	public final GLColor getColorGuiSelected()
	{
		return _colorGuiSelected;
	}
	
	public final GLColor getColorFlat()
	{
		return _colorFlat;
	}
	
	public final GLColor getColorComplex()
	{
		return _colorComplex1;
	}
	
	public final GLColor getColorMultiLayer()
	{
		return _colorMutliLayer1a;
	}
	
	/**
	 * For the cells inside the selection box
	 * 
	 * @return
	 */
	public final GLColor getColorMultiLayerSpecial()
	{
		return _colorMutliLayer1b;
	}
	
	public final GLColor getColor(final GeoCell cell)
	{
		if (FrameMain.getInstance().isSelectedGeoCell(cell))
			return _colorGuiSelected;
		
		return getColor(cell.getBlock(), GLDisplay.getInstance().getSelectionBox().isInside(cell));
	}
	
	public final GLColor getColor(final GeoBlock block, final boolean insideSelectionBox)
	{
		switch (block.getType())
		{
			case GeoEngine.GEO_BLOCK_TYPE_FLAT:
				return _colorFlat;
				
			case GeoEngine.GEO_BLOCK_TYPE_COMPLEX:
				return block.getBlockX() % 2 != block.getBlockY() % 2 ? _colorComplex2 : _colorComplex1;
				
			default:
			{
				if (insideSelectionBox)
					return block.getBlockX() % 2 != block.getBlockY() % 2 ? _colorMutliLayer2b : _colorMutliLayer1b;
				
				return block.getBlockX() % 2 != block.getBlockY() % 2 ? _colorMutliLayer2a : _colorMutliLayer1a;
			}
		}
	}
}