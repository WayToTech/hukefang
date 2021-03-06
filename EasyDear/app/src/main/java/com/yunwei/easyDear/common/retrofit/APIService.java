package com.yunwei.easyDear.common.retrofit;

import com.yunwei.easyDear.BuildConfig;
import com.yunwei.easyDear.entity.ResponseModel;
import com.yunwei.easyDear.function.account.data.UserInfoEntity;
import com.yunwei.easyDear.function.mainFuncations.articleFunction.ArticleItemEntity;
import com.yunwei.easyDear.function.account.data.ValidateCodeEntity;
import com.yunwei.easyDear.function.mainFuncations.businessFunction.CardItemEntity;
import com.yunwei.easyDear.function.mainFuncations.businessFunction.BusinessDetailEntity;
import com.yunwei.easyDear.function.mainFuncations.locationFunction.LocationEntity;
import com.yunwei.easyDear.function.mainFuncations.membershipFuncation.data.BillEntity;
import com.yunwei.easyDear.function.mainFuncations.membershipFuncation.data.CardEntity;
import com.yunwei.easyDear.function.mainFuncations.messageFunction.data.MessageItemEntity;
import com.yunwei.easyDear.function.mainFuncations.messageFunction.data.MessageDetailEntity;
import com.yunwei.easyDear.function.mainFuncations.mymemberlistFunction.data.BusinessEntity;
import com.yunwei.easyDear.function.mainFuncations.myorderlistFunction.data.OrderEntity;
import com.yunwei.easyDear.function.mainFuncations.searchFunction.SearchHotEntity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.common.retrofit
 * @Description:请求API接口配制
 * @date 2016/11/29 15:50
 */

public interface APIService {
    /**
     * 登录
     *
     * @param mobile
     * @param password
     * @return
     */
    @GET(BuildConfig.LOGIN_URL)
    Call<ResponseModel<UserInfoEntity>> loginRepo(@Query("mobile") String mobile, @Query("password") String password);

    /**
     * 注册
     *
     * @param mobile
     * @param password
     * @param mobileKey
     * @return
     */
    @GET(BuildConfig.REGIST_URL)
    Call<ResponseModel<UserInfoEntity>> registRepo(@Query("mobile") String mobile, @Query("password") String password, @Query("code") String code, @Query("mobileKey") String mobileKey);

    /**
     * 发送验证码
     *
     * @param MobileCode
     * @return
     */
    @GET(BuildConfig.SEND_VALIDATE_CODE)
    Call<ResponseModel<ValidateCodeEntity>> sendValidateCode(@Query("mobile") String MobileCode);

    /**
     * 密码修改
     *
     * @param userNo
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @GET(BuildConfig.UPDATE_PASSWORD)
    Call<ResponseModel> updatePassword(@Query("userNo") String userNo, @Query("oldPassword") String oldPassword, @Query("newPassword") String newPassword);

    /**
     * 昵称修改
     *
     * @param nickName
     * @param userNo
     * @return
     */
    @GET(BuildConfig.UPDATE_NICK_NAME)
    Call<ResponseModel> updateNickName(@Query("nickName") String nickName, @Query("userNo") String userNo);

    /**
     * 订单列表
     *
     * @param userNo
     * @param pageSize
     * @param pageCount
     * @return
     */
    @GET(BuildConfig.BILL_LIST_URL)
    Call<ResponseModel<List<OrderEntity>>> reqOrderList(@Query("userNo") String userNo, @Query("getPageSize") int pageSize, @Query("getPageCount") int pageCount);

    /**
     * 商家列表
     *
     * @param userNo
     * @param pageSize
     * @param pageCount
     * @return
     */
    @GET(BuildConfig.BUSINESS_LIST_URL)
    Call<ResponseModel<List<BusinessEntity>>> reqBusinessList(@Query("userNo") String userNo, @Query("getPageSize") int pageSize, @Query("getPageCount") int pageCount);

    /**
     * 消费券列表
     *
     * @param userNo
     * @return
     */
    @GET(BuildConfig.CARD_LIST_URL)
    Call<ResponseModel<List<com.yunwei.easyDear.function.mainFuncations.mycardlistFunction.data.CardEntity>>> reqCardList(@Query("userNo") String userNo);

    /**
     * 卡券数量
     *
     * @param userNo
     * @return
     */
    @GET(BuildConfig.CARD_COUNT_URL)
    Call<ResponseModel<CardEntity>> reqCardCount(@Query("userNo") String userNo);

    /**
     * 商家数量
     *
     * @param userNo
     * @return
     */
    @GET(BuildConfig.BUSINESS_COUNT_URL)
    Call<ResponseModel<com.yunwei.easyDear.function.mainFuncations.membershipFuncation.data.BusinessEntity>> reqBusinessCount(@Query("userNo") String userNo);

    /**
     * 订单数量
     *
     * @param userNo
     * @return
     */
    @GET(BuildConfig.BILL_COUNT_URL)
    Call<ResponseModel<BillEntity>> reqBillCount(@Query("userNo") String userNo);

    /**
     * 请求七牛Token
     *
     * @return
     */
    @GET(BuildConfig.QINIU_TOKEN_URL)
    Call<ResponseModel<String>> reqQiniuToken();

    /***
     * 获取首页顶部轮播文章列表
     */
    @GET(BuildConfig.HOME_TOP_SCROLL_ARTICLE_LIST)
    Call<ResponseModel<ArrayList<ArticleItemEntity>>> reqHomeTopScrollArticleList(@Query("province") String province, @Query("city") String city, @Query("area") String area);

    /**
     * 获取首页文章列表
     */
    @GET(BuildConfig.HOME_ARTICLE_LIST)
    Call<ResponseModel<ArrayList<ArticleItemEntity>>> reqHomeArticleList(@Query("pageSize") int pageSize, @Query("pageCount") int pageCount,
                                                                         @Query("key") String key, @Query("type") String type,
                                                                         @Query("province") String province, @Query("city") String city, @Query("area") String area);

    /**
     * 文章详情
     */
    @GET(BuildConfig.ARTICLE_DETAIL)
    Call<ResponseModel<ArticleItemEntity>> requestArticleDetail(@Query("articleId") String articleId);

    /**
     * 文章详情
     */
    @GET(BuildConfig.BUSINESS_DETAIL)
    Call<ResponseModel<BusinessDetailEntity>> requestBusinessDetail(@Query("businessNo") String businessNo, @Query("userNo") String userNo);

    /**
     * 最新卡券信息
     */
    @GET(BuildConfig.LATEST_CARD_INFO)
    Call<ResponseModel<ArrayList<CardItemEntity>>> requestLatestCardInfo(@Query("businessNo") String businessNo, @Query("pageSize") int pageSize, @Query("pageCount") int pageCount);

    /**
     * 卡券详情
     */
    @GET(BuildConfig.CARD_INFO_DETAIL)
    Call<ResponseModel<CardItemEntity>> requestCardDetail(@Query("cardNo") String cardNo);

    /**
     * 商家软文列表
     */
    @GET(BuildConfig.BUSINESS_ARTICLE_LIST)
    Call<ResponseModel<ArrayList<ArticleItemEntity>>> requestBusinessArticles(@Query("businessNo") String businessNo, @Query("pageSize") int pageSize, @Query("pageCount") int pageCount);

    /**
     * 获取系统消息列表
     */
    @GET(BuildConfig.TUI_MESSAGE_LIST)
    Call<ResponseModel<ArrayList<MessageItemEntity>>> requestTuiMessages(@Query("userNo") String userNo, @Query("pageSize") int pageSize, @Query("pageCount") int pageCount);

    /**
     * 获取商家消息列表
     */
    @GET(BuildConfig.BUSINESS_MESSAGE_LIST)
    Call<ResponseModel<ArrayList<MessageItemEntity>>> requestBusMessages(@Query("userNo") String userNo, @Query("pageSize") int pageSize, @Query("pageCount") int pageCount);

    /**
     * 获取系统消息详情
     */
    @GET(BuildConfig.TUI_MESSAGE_LIST)
    Call<ResponseModel<List<MessageDetailEntity>>> reqTuiMessageDetail(@Query("userNo") String userNo, @Query("pageSize") int pageSize, @Query("pageCount") int pageCount);

    /**
     * 获取单个商家信息详情
     *
     * @param userNo
     * @param businessNo
     * @param pageSize
     * @param pageCount
     * @return
     */
    @GET(BuildConfig.MESSAGE_DETAIL_URL)
    Call<ResponseModel<List<MessageDetailEntity>>> reqMessageDetail(@Query("userNo") String userNo, @Query("businessNo") String businessNo, @Query("pageSize") int pageSize, @Query("pageCount") int pageCount);

    /**
     * 搜索热门
     */
    @GET(BuildConfig.SEARCH_HOT)
    Call<ResponseModel<List<SearchHotEntity>>> reqHotSearch();

    /**
     * 获取城市列表
     */
    @GET(BuildConfig.LOCATION_CITY)
    Call<ResponseModel<List<LocationEntity>>> reqCity();

    /**
     * 获取区域列表
     */
    @GET(BuildConfig.LOCATION_AREA)
    Call<ResponseModel<List<LocationEntity>>> reqDistrict(@Query("code") String code);
}
