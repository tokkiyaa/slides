def makeQuery(productType: Long, customerType: Long, comment: String): String = {
  val productQuery = s"SELECT id, name, price FROM product where product_type = ${productType}"
  val saleQuery = s"SELECT product_id, amount FROM sale WHERE customer_type = ${customerType}"

  s"""
    SELECT p.name , MIN(p.price) * SUM(s.amount), '${comment}'
    FROM  (${productQuery}) AS p
          INNER JOIN (${saleQuery}) AS s
          ON p.id = s.product_id
    GROUP BY p.id, p.name
  """
}
