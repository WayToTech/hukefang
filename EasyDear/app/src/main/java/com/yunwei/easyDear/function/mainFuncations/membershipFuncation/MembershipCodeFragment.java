package com.yunwei.easyDear.function.mainFuncations.membershipFuncation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yunwei.easyDear.BuildConfig;
import com.yunwei.easyDear.R;
import com.yunwei.easyDear.base.BaseFragment;
import com.yunwei.easyDear.base.DataApplication;
import com.yunwei.easyDear.function.account.data.UserInfoEntity;
import com.yunwei.easyDear.function.mainFuncations.mycardlistFunction.MyCardActivity;
import com.yunwei.easyDear.function.mainFuncations.mymemberlistFunction.MyMemberActivity;
import com.yunwei.easyDear.function.mainFuncations.myorderlistFunction.MyOrderActivity;
import com.yunwei.easyDear.utils.ISkipActivityUtil;
import com.yunwei.easyDear.utils.IUtil;
import com.yunwei.easyDear.view.RoundedBitmapImageViewTarget;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Describe:会员码
 * Author: hezhiWu
 * Date: 2017-01-08
 * Time: 13:46
 * Version:1.0
 */

public class MembershipCodeFragment extends BaseFragment {

    private static MembershipCodeFragment fagment;
    @BindView(R.id.MembershiFrgment_bg_iv)
    ImageView MembershiFrgmentBgIv;
    @BindView(R.id.MembershipFragment_headView_iv)
    ImageView headView;
    @BindView(R.id.MembershipFragment_Name_textView)
    TextView userName;
    @BindView(R.id.MembershipFragment_qr_iv)
    ImageView qrImageView;
    @BindView((R.id.MembershipFragment_card_count_textView))
    TextView cardCountTextView;
    @BindView((R.id.MembershipFragment_business_count_textView))
    TextView businessCountTextView;
    @BindView(R.id.MembershipFragment_bill_count_textView)
    TextView billCountTextView;

    private BillPresenter billPresenter;

    public static MembershipCodeFragment newInstance() {
        if (fagment == null) {
            fagment = new MembershipCodeFragment();
        }
        return fagment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_frgment_membership, null);
        ButterKnife.bind(this, rootView);
        initUI();
        initCountUI();
        return rootView;
    }

    private void initUI() {
        UserInfoEntity entity = DataApplication.getInstance().getUserInfoEntity();
        if (entity != null) {
            userName.setText(entity.getNickName());
            qrImageView.setImageBitmap(IUtil.createQRImage(entity.getUserNo(), 120, 120));
            Glide.with(getActivity()).load(BuildConfig.DOMAI+entity.getImagery()).asBitmap().centerCrop().error(R.mipmap.homepage_headimg_defaut).into(new RoundedBitmapImageViewTarget(headView));
        } else {
            Glide.with(getContext()).load("http://www.wendu.com/upload/12-02-06/dizhiqr.jpeg").into(qrImageView);
            Glide.with(getContext()).load("http://img.dongqiudi.com/uploads/avatar/2014/10/20/8MCTb0WBFG_thumb_1413805282863.jpg").asBitmap().centerCrop().error(R.mipmap.homepage_headimg_defaut).into(new RoundedBitmapImageViewTarget(headView));
        }
        Glide.with(getContext()).load("http://www.popoffices.com/design/pin/opn/006.jpg").into(MembershiFrgmentBgIv);
    }

    private void initCountUI() {
        billPresenter = new BillPresenter(new BillContract.CardView() {
            @Override
            public void onCardSuccess(int size) {
                cardCountTextView.setText(size + "");
            }

            @Override
            public void onCardFalire(String error) {

            }

            @Override
            public String getUserNo() {
                return null;
            }
        });
        billPresenter.reqCardAction();

        billPresenter = new BillPresenter(new BillContract.BusinessView() {
            @Override
            public void onBusinessSuccess(int size) {
                businessCountTextView.setText(size + "");
            }

            @Override
            public void onBusinessFalire(String error) {

            }

            @Override
            public String getUserNo() {
                return null;
            }
        });
        billPresenter.reqBusinessAction();

        billPresenter = new BillPresenter(new BillContract.BillssView() {
            @Override
            public void onBillSuccess(int size) {
                billCountTextView.setText(size + "");
            }

            @Override
            public void onBillFalire(String error) {

            }

            @Override
            public String getUserNo() {
                return null;
            }
        });
        billPresenter.reqBillAction();
    }

    @OnClick({R.id.MembershipFragment_order_layout, R.id.MembershipFragment_block_layout, R.id.MembershipFragment_ll_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.MembershipFragment_ll_layout:
                ISkipActivityUtil.startIntent(getActivity(), MyCardActivity.class);
                break;
            case R.id.MembershipFragment_block_layout:
                ISkipActivityUtil.startIntent(getActivity(), MyMemberActivity.class);
                break;
            case R.id.MembershipFragment_order_layout:
                ISkipActivityUtil.startIntent(getActivity(), MyOrderActivity.class);
                break;
        }
    }
}
