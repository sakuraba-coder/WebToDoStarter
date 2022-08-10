//「月別データ」

//const cols = [ "１月", "２月", "３月", "４月", "５月", "６月", "７月" ];

const dataAry = [ 65, 59, 80, 81, 56, 55, 48 ];

console.log(pantz);

var mydata = {
	labels : cols,
	datasets : [ {
		label : '数量',
		hoverBackgroundColor : "rgba(255,99,132,0.3)",
		data : dataAry ,
	} ]
};

// 「オプション設定」
var options = {
	title : {
		display : true,
		text : 'サンプルチャート'
	}
};

var canvas = document.getElementById('graph');
var chart = new Chart(canvas, {

	type : 'line', // グラフの種類
	data : mydata, // 表示するデータ
	options : options
// オプション設定

});
