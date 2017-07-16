def makeQuery(accountId: Long): String = {
  val accountQuery = "SELECT id, name FROM account WHERE del_flg = 0"
  val userQuery = "SELECT id, name, sex, age, district FROM user WHERE del_flg = 0"

  val account = "a"
  val user = "u"

  val accountItems = s"MIN(${account}.id) AS account_id, MIN(${account}.name) AS account_name"
  val userItems = s"${user}.${grouping} AS ${grouping}, COUNT(*) AS count"
  val condition = s"${account}.id = {$accountId}"

  s"""SELECT ${accountItems}, ${userItems}
     |FROM (${accountQuery}) AS ${account}
     |     INNER JOIN (${userQuery}) AS ${user}
     |       ON ${account}.id = ${user}.accountId
     |WHERE ${condition}
     |GROUP BY ${user}.${grouping}
  """.stripMargin
}
