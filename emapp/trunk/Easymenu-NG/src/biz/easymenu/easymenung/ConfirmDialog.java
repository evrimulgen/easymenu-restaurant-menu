/*******************************************************************************
 * Copyright 2012 Gianrico D'Angelis  -- gianrico.dangelis@gmail.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package biz.easymenu.easymenung;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmDialog extends DialogFragment {

	private LayoutInflater li = null;
	private String text = null; 
	private String yesStr = null;
	private String noStr = null;
	private View.OnClickListener yesListener = null;
	private View.OnClickListener noListener = null;
	private Button btnYes = null;
	private Button btnNo = null;
	
	
	ConfirmDialog(String text,String yesStr,String noStr,View.OnClickListener yesListener,View.OnClickListener noListener){
		this.text = text;
		this.yesStr = yesStr;
		this.noStr = noStr;
		this.yesListener = yesListener;
		this.noListener = noListener;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  li = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
        View v = li.inflate(R.layout.confirmdialog, container, false);
        ((TextView)v.findViewById(R.id.txtConfDlg)).setText(text);
       
        btnYes = (Button)v.findViewById(R.id.btnConfDlgYes);
        btnNo = (Button)v.findViewById(R.id.btnConfDlgNo);
        
        btnYes.setText(yesStr);
        btnNo.setText(noStr);
        
        WindowManager.LayoutParams WMLP = this.getDialog().getWindow().getAttributes();
        WMLP.y = 100;   //y position
        WMLP.gravity = Gravity.TOP;
        WMLP.windowAnimations = R.style.PauseDialogAnimation;
        this.getDialog().getWindow().setAttributes(WMLP);
        this.getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        btnYes.setOnClickListener(yesListener);
        btnNo.setOnClickListener(noListener);
        
        return v;
	}
	
}
