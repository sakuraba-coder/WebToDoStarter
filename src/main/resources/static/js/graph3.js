
var jsonfile = {
	"jsonarray": JSON.parse(str)
};

var labels = jsonfile.jsonarray.map(function(e) {
   return e.x;
});
var data = jsonfile.jsonarray.map(function(e) {
   return e.y;
});;

var ctx = canvas.getContext('2d');
var config = {
   type: 'line',
   data: {
      labels: labels,
      datasets: [{
         label: '試行回数',
         data: data,
         backgroundColor: 'rgba(0, 119, 204, 0.3)'
      }]
   }
};

var chart = new Chart(ctx, config);