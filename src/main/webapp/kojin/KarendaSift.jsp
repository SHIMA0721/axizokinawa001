<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table style="" id="calenderTable" class="persist-table layout-fixed">
			<colgroup>
				<col span="1" style="background-color: #FFEBEB;">
				<col span="5" style="background-color: #FFFFFF">
				<col span="1" style="background-color: #F3FDFF">
			</colgroup>
			<caption>2016年3月</caption>

			<tr>
				<td><a href="KarendaMein.jsp">2月</a></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="KarendaMein.jsp">4月</a></td>
			</tr>
			<tr>
				<td style="color: #C30;">日</td>
				<td style="background-color: #FAFAFA;">月</td>
				<td style="background-color: #FAFAFA;">火</td>
				<td style="background-color: #FAFAFA;">水</td>
				<td style="background-color: #FAFAFA;">木</td>
				<td style="background-color: #FAFAFA;">金</td>
				<td style="color: #03C;">土</td>
			</tr>
			<tr>
				<td class="blankday">&nbsp;</td>
				<td class="blankday">&nbsp;</td>
				<td style=""><a href="KarendaMein.jsp">1</a></td>
				<td style=""><a href="KarendaMein.jsp">2</a></td>
				<td style=""><a href="KarendaMein.jsp">3</a></td>
				<td style=""><a href="KarendaMein.jsp">4</a></td>
				<td style="color: #03C;"><a href="KarendaMein.jsp">5</a></td>
			</tr>
			<tr>
				<td style="color: #C30;"><a href="KarendaMein.jsp">6</a></td>
				<td style=""><a href="KarendaMein.jsp">7</a></td>
				<td style=""><a href="KarendaMein.jsp">8</a></td>
				<td style=""><a href="KarendaMein.jsp">9</a></td>
				<td style=""><a href="KarendaMein.jsp">10</a></td>
				<td style=""><a href="KarendaMein.jsp">11</a></td>
				<td style="color: #03C;"><a href="KarendaMein.jsp">12</a></td>
			</tr>
			<tr>
				<td style="color: #C30;"><a href="KarendaMein.jsp">13</a></td>
				<td style=""><a href="KarendaMein.jsp">14</a></td>
				<td style=""><a href="KarendaMein.jsp">15</a></td>
				<td style=""><a href="KarendaMein.jsp">16</a></td>
				<td style=""><a href="KarendaMein.jsp">17</a></td>
				<td style=""><a href="KarendaMein.jsp">18</a></td>
				<td style="color: #03C;"><a href="KarendaMein.jsp">19</a></td>
			</tr>
			<tr>
				<td style="color: #C30;"><a href="KarendaMein.jsp">20</a></td>
				<td style=""><a href="KarendaMein.jsp">21</a></td>
				<td style=""><a href="KarendaMein.jsp">22</a></td>
				<td style=""><a href="KarendaMein.jsp">23</a></td>
				<td style=""><a href="KarendaMein.jsp">24</a></td>
				<td style=""><a href="KarendaMein.jsp">25</a></td>
				<td style="color: #03C;"><a href="KarendaMein.jsp">26</a></td>
			</tr>
			<tr>
				<td style="color: #C30;"><a href="KarendaMein.jsp">27</a></td>
				<td style=""><a href="KarendaMein.jsp">28</a></td>
				<td style=""><a href="KarendaMein.jsp">29</a></td>
				<td style=""><a href="KarendaMein.jsp">30</a></td>
				<td style=""><a href="KarendaMein.jsp">31</a></td>
				<td class="blankday">&nbsp;</td>
				<td class="blankday">&nbsp;</td>
			</tr>
		</table>


<br><br>
		<form name=f method=POST action="Ok.jsp">
			<h3>シフト入力</h3>

			<select name="blood">
				<option value="" selected>アルバイト</option>
				<option value="YOSI">吉野家</option>
				<option value="MAC">マック</option>
				<option value="GAST">ガスト</option>
			</select>

<br><br>
			出勤日<select>
						<option value="01month">1月</option>
						<option value="02month">2月</option>
						<option value="03month">3月</option>
						<option value="04month">4月</option>
						<option value="05month">5月</option>
						<option value="06month">6月</option>
						<option value="07month">7月</option>
						<option value="08month">8月</option>
						<option value="09month">9月</option>
						<option value="10month">10月</option>
						<option value="11month">11月</option>
						<option value="12month">12月</option>
					</select>
			<select>
						<option value="01day">1日</option>
						<option value="02day">2日</option>
						<option value="03day">3日</option>
						<option value="04day">4日</option>
						<option value="05day">5日</option>
						<option value="06day">6日</option>
						<option value="07day">7日</option>
						<option value="08day">8日</option>
						<option value="09day">9日</option>
						<option value="10day">10日</option>
						<option value="11day">11日</option>
						<option value="12day">12日</option>
						<option value="13day">13日</option>
						<option value="14day">14日</option>
						<option value="15day">15日</option>
						<option value="16day">16日</option>
						<option value="17day">17日</option>
						<option value="18day">18日</option>
						<option value="19day">19日</option>
						<option value="20day">20日</option>
						<option value="21day">21日</option>
						<option value="22day">22日</option>
						<option value="23day">23日</option>
						<option value="24day">24日</option>
						<option value="25day">25日</option>
						<option value="26day">26日</option>
						<option value="27day">27日</option>
						<option value="28day">28日</option>
						<option value="29day">29日</option>
						<option value="30day">30日</option>
						<option value="31day">31日</option>
						</select>

					<br><br>
					開始時刻 <select>
						<option value="01">1時</option>
						<option value="02">2時</option>
						<option value="03">3時</option>
						<option value="04">4時</option>
						<option value="05">5時</option>
						<option value="06">6時</option>
						<option value="07">7時</option>
						<option value="08">8時</option>
						<option value="09">9時</option>
						<option value="10">10時</option>
						<option value="11">11時</option>
						<option value="12">12時</option>
						<option value="13">13時</option>
						<option value="14">14時</option>
						<option value="15">15時</option>
						<option value="16">16時</option>
						<option value="17">17時</option>
						<option value="18">18時</option>
						<option value="19">19時</option>
						<option value="20">20時</option>
						<option value="21">21時</option>
						<option value="22">22時</option>
						<option value="23">23時</option>
						<option value="0">0時</option>
						</select>
						<select>
						<option value="00minute">00分</option>
						<option value="30minute">30分</option>
						</select><br>


					終了時刻
				 <select>
						<option value="01">1時</option>
						<option value="02">2時</option>
						<option value="03">3時</option>
						<option value="04">4時</option>
						<option value="05">5時</option>
						<option value="06">6時</option>
						<option value="07">7時</option>
						<option value="08">8時</option>
						<option value="09">9時</option>
						<option value="10">10時</option>
						<option value="11">11時</option>
						<option value="12">12時</option>
						<option value="13">13時</option>
						<option value="14">14時</option>
						<option value="15">15時</option>
						<option value="16">16時</option>
						<option value="17">17時</option>
						<option value="18">18時</option>
						<option value="19">19時</option>
						<option value="20">20時</option>
						<option value="21">21時</option>
						<option value="22">22時</option>
						<option value="23">23時</option>
						<option value="0">0時</option>
						</select>
						<select>
						<option value="00minute">00分</option>
						<option value="30minute">30分</option>
						</select>

						<br><br>
		<input type="submit" value="送信"> <br>
		</form>
			<br>

<br>
<br> <A HREF="KarendaMein.jsp">戻る</A>

<br> <br> <A HREF="login.jsp">ログアウト</A>
	</div>


</body>
</html>