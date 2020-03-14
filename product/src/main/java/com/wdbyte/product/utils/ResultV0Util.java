package com.wdbyte.product.utils;

import com.wdbyte.product.VO.ResultVO;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/7 21:51
 */
public class ResultV0Util {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
