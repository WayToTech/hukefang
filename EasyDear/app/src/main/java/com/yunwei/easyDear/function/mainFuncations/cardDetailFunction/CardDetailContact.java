package com.yunwei.easyDear.function.mainFuncations.cardDetailFunction;

import com.yunwei.easyDear.function.mainFuncations.businessFunction.CardItemEntity;

/**
 * Created by LJH on 2017/1/21.
 */

public interface CardDetailContact {

    interface CardDetailView {
        void showDialog();

        void dimissDialog();

        void onCardDetailInfoSuccess(CardItemEntity data);

        void onCardDetailInfoFailure(String error);
    }

    interface Presenter {
        void requestCardDetail(String cardNo);
    }
}
