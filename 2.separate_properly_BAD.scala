def makeQuery(accountId: Long, grouping: String): String = {
  val accountSubq = "(SELECT id FROM account WHERE del_flg = 0) as a"
  val userSubq = "(SELECT id, name, sex, age, district FROM user WHERE del_flg = 0) as u"

  val select = s"SELECT MIN(a.id) AS account_id, MIN(a.name) AS account_name, u.${grouping} AS ${grouping}, COUNT(*) AS count"
  val from = s"${accountSubq} INNER JOIN ${userSubq} ON a.id = u.accountId"
  val where = s"WHERE a.account_id = {$accountId}"
  val groupBy = s"GROUP BY u.${grouping}"

  s"""${select}
     |${from}
     |${where}
     |${groupBy}
  """.stripMargin
}
