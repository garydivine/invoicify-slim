$(function () {
	
	$('#flat-fee-form').submit(function (e) {
		e.preventDefault();
		
		let record = {
				amount : $('#flat-fee-amount').val(),
				description : $('#flat-fee-description').val(),
				client: {
					id : $('#flat-fee-clientId').val()
				}
			};
		
		let headers = {
				'X-CSRF-TOKEN': $('#flat-fee-csrf').val()
			};
		let settings = {
				url: '/api/flatfees',
				headers: headers,
				data: JSON.stringify(record),
				contentType: 'application/json'
			};
		$.post(settings)
		 .done(function (data) {
			 $('#tableBody')
			 	.append(
			 			`<tr>
					        <td>${data.createdBy.username}</td>
					        <td>${data.description}</td>
					        <td>${data.client.name}</td>
					        <td>$ ${data.amount}</td>
					        <td>$</td>
					        <td></td>
					        <td>$ ${data.total}</td>
					     </tr>`);
			 $('#flat-fee-amount').val('');
			 $('#flat-fee-description').val('');
			 $('#flat-fee-clientId').val('');
		 });
	});
	
	$('#rate-based-form').submit(function (e) {
		e.preventDefault();
		
		let record = {
				rate : $('#rate-based-rate').val(),
				quantity : $('#rate-based-quantity').val(),
				description : $('#rate-based-description').val(),
				client: {
					id : $('#rate-based-clientId').val()
				}
			};
		
		let headers = {
				'X-CSRF-TOKEN': $('#rate-based-csrf').val()
			};
		let settings = {
				url: '/api/ratefees',
				headers: headers,
				data: JSON.stringify(record),
				contentType: 'application/json'
			};
		$.post(settings)
		 .done(function (data) {
			 $('#tableBody')
			 	.append(
			 			`<tr>
					        <td>${data.createdBy.username}</td>
					        <td>${data.description}</td>
					        <td>${data.client.name}</td>
					        <td>$</td>
					        <td>$ ${data.rate}</td>
					        <td>${data.quantity}</td>
					        <td>$ ${data.total}</td>
					     </tr>`);
			 $('#rate-based-rate').val('');
			 $('#rate-based-quantity').val('');
			 $('#rate-based-clientId').val('');
			 $('#rate-based-description').val('');
		 });
	});
	
});