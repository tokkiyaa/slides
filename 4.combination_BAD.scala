def makeQuery(productType: Long, customerType: Long, comment: String): String =
  s"""
    SELECT p.name , MIN(p.price) * SUM(s.amount), '${comment}'
    FROM  (SELECT id, name, price FROM product where product_type = ${productType}) AS p
          INNER JOIN (SELECT product_id, amount FROM sale WHERE customer_type = ${customerType}) AS s
          ON p.id = s.product_id
    GROUP BY p.id, p.name
  """
