package com.wdbyte.order.utils;

import com.wdbyte.order.VO.ResultVO;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/12 22:06
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
