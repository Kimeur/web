console.log("kkd");
window.onload = function() {
	var salaries_labels= [];
	var salaries_values= []
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
	console.log(salaries_labels);
	console.log(salaries_values);
	var ctx = document.getElementById('myChart').getContext('2d');
	
	var chart = new Chart(ctx, {
	    // The type of chart we want to create
	    type: 'line',

	    // The data for our dataset
	    data: {
	        labels: salaries_labels,
	        datasets: [{
	            label: "Salaries",
	            data: salaries_values,
	            
	        }]
	    },

	    // Configuration options go here
	    options: {}
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