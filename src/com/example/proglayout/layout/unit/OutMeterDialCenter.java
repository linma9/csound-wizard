package com.example.proglayout.layout.unit;

import android.view.View;

import com.example.proglayout.csound.listener.CachedOutputSlide;
import com.example.proglayout.layout.LayoutContext;
import com.example.proglayout.layout.SetLayoutParam.LayoutParent;
import com.example.proglayout.layout.UnitUtils;
import com.example.proglayout.layout.UnitUtils.WithId;
import com.example.proglayout.layout.Units;
import com.example.proglayout.layout.Units.Unit;
import com.example.proglayout.model.TrackState;
import com.example.proglayout.view.param.Param;
import com.example.proglayout.view.unit.MeterDial;

public class OutMeterDialCenter implements Unit {
	@Override
	public String getTag() {			
		return Units.CENTER_CIRCLE_METER;
	}
	
	@Override
	public View getView(final LayoutContext ctx, final Object tagValue, final Param param, final Param defaults, final TrackState trackState, final LayoutParent layoutParent) {		
		
		return UnitUtils.run(this, ctx, tagValue, new WithId() {
			@Override
			public View apply(String id) {								
				MeterDial res = new MeterDial(ctx.getContext(), param.getRange().getRange(), true);
				new CachedOutputSlide(id, res).addToCsound(ctx.getApp());				
				return res;
			}			
		});		
	}	
	
	
}
