package com.csound.wizard.layout.unit;

import android.view.View;

import com.csound.wizard.Const;
import com.csound.wizard.csound.listener.Tap2;
import com.csound.wizard.layout.LayoutContext;
import com.csound.wizard.layout.SetLayoutParam.LayoutParent;
import com.csound.wizard.layout.UnitUtils;
import com.csound.wizard.layout.UnitUtils.WithInstrId;
import com.csound.wizard.layout.Units.Unit;
import com.csound.wizard.layout.param.Param;
import com.csound.wizard.model.TrackState;
import com.csound.wizard.view.unit.TapClickBoard;

public class TapClick implements Unit {
	
	@Override
	public String getTag() {		
		return Const.TAP_CLICK;
	}

	@Override
	public View getView(final LayoutContext ctx, final Object tagValue, final Param param, final Param defaults, TrackState trackState, final LayoutParent layoutParent) {
		return UnitUtils.run(this, ctx, tagValue, new WithInstrId() {
			@Override
			public View apply(Integer id) {				
				TapClickBoard res = new TapClickBoard(ctx.getContext(), 
						param.getRange().getIntRangeX(), param.getRange().getIntRangeY(), param.getNames().getNameList(),						
						param.getColor(), param.getText());
				new Tap2(id, res).addToCsound(ctx.getCsoundObj());				
				return res;
			}			
		});		
	}	
}
