console.log("kkd");
window.onload = function() {
	var salaries_labels= [];
	var salaries_values= [];
	for (var key in tab) {
		var salary = tab[key].salary;
		if (salaries_labels.includes(salary) == 1)
			{
			salaries_values[salaries_labels.indexOf(salary)]++;
			}
		else
			{
			salaries_labels.push(salary);
			salaries_values[salaries_labels.indexOf(salary)]=1;
			}
		};
	var salaries = salaries_labels.map( (x, i) => {
		    return {"salary": x, "number_employee": salaries_values[i]}        
		});
	
	var salaries = salaries.slice(0);
	salaries.sort(function(a,b) {
		return b.number_employee - a.number_employee;
	});
	var ctx = document.getElementById('myChart').getContext('2d');
	
	var data = {
			labels: [],
		    datasets: [{
		        label: "Salaries",
		        backgroundColor: "rgba(75,192,192,0.4)",
		        borderColor: "rgba(75,192,192,1)",
		        data: []
		    }]
		};

		Chart.pluginService.register({
		    beforeInit: function(chart) {
		        var data = chart.config.data;
		        for (var key in salaries) {
		            if (salaries.hasOwnProperty(key)) {
		            	data.labels.push(salaries[key].salary);
		                data.datasets[0].data.push(salaries[key].number_employee);
		            }
		        }
		    }
		});

		var myBarChart = new Chart(ctx, {
		    type: 'line',
		    data: data,
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});

	};


function ffd(a){
	console.log(a)
};

function getEmployee(a){
	console.log(a);
	var result= JSON.parse(a);
	console.log("hahahaha");
	console.log(result);
};