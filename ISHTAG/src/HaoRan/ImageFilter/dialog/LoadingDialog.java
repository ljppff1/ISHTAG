package HaoRan.ImageFilter.dialog;


import com.example.ishtag.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadingDialog extends AlertDialog {
	private View mView;
	private String mHintContent;
	private ImageView mIvld;
	private Context content;
	public LoadingDialog(Context context, String hintContent) {
		super(context);
		mHintContent = hintContent;
		this.content =context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mView = LayoutInflater.from(getContext()).inflate(R.layout.loading_dialog, null);
		TextView hintText = (TextView) mView.findViewById(R.id.dialog_hint_text);
		hintText.setText(mHintContent);
		setContentView(mView);
		mIvld =(ImageView)this.findViewById(R.id.mIvld);
		Animation operatingAnim = AnimationUtils.loadAnimation(content, R.anim.tip);  
		LinearInterpolator lin = new LinearInterpolator();  
		operatingAnim.setInterpolator(lin);  
		if (operatingAnim != null) {  
			mIvld.startAnimation(operatingAnim);  
		}  
		
		setCanceledOnTouchOutside(false);

		setOnDismissListener(new OnDismissListener() {

			@Override
			public void onDismiss(DialogInterface dialog) {
			}
		});

	}

}
