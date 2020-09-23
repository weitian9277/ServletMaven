package JDBC.dao;

import JDBC.eneity.ByBook;

import java.util.List;

/**
 * 修改备注:  [说明本次修改内容]
 * 版本:      [v1.0]
 */
public interface ByBookDao {

   // 买书
   int  ByBookAdd(Object[] params);

   // 跟据id查询他的书架
   List<ByBook> selectNameBoo(int id);


   //跟据用户id  和  商品id 进行上传

   int  delCarBook(String userId, String goodsId);
}
