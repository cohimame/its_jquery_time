(function() {
  jQuery(function($) {
    var $table, loadProductDetails, loadProductTable, productDetailsUrl, productListUrl, saveRow;
    $table = $('.container table');
    productListUrl = $table.data('list');


    var fslink = $('.experiment .brand').attr('href');
    var fstable = $('.fstable');

    loadFs = function() {
      return $.get(fslink, function(agentJson){
          var row = $('<tr/>').append($('<td/>').text(agentJson.agentAddress));

          fstable.append(row)
      })
    }

    loadFs()

    loadProductTable = function() {
      return $.get(productListUrl, function(products) {
        return $.each(products, function(index, eanCode) {
          var row;
          row = $('<tr/>').append($('<td/>').text(eanCode));
          row.attr('contenteditable', true);
          $table.append(row);
          return loadProductDetails(row);
        });
      });
    };

    productDetailsUrl = function(eanCode) {
      return $table.data('details').replace('0', eanCode);
    };

    loadProductDetails = function(tableRow) {
      var eanCode;
      eanCode = tableRow.text();
      return $.get(productDetailsUrl(eanCode), function(product) {
        tableRow.append($('<td/>').text(product.name));
        tableRow.append($('<td/>').text(product.description));
        return tableRow.append($('<td/>'));
      });
    };

    loadProductTable();

    saveRow = function($row) {
      var description, ean, jqxhr, name, product, _ref;

      _ref = $row.children().map(function() {
        return $(this).text();
      }), ean = _ref[0], name = _ref[1], description = _ref[2];

      product = {
        ean: parseInt(ean),
        name: name,
        description: description
      };

      jqxhr = $.ajax({
        type: "PUT",
        url: productDetailsUrl(ean),
        contentType: "application/json",
        data: JSON.stringify(product)
      });

      jqxhr.done(function(response) {
        var $label;
        $label = $('<span/>').addClass('label label-success');
        $row.children().last().append($label.text(response));
        return $label.delay(3000).fadeOut();
      });

      return jqxhr.fail(function(data) {
        var $label, message;
        $label = $('<span/>').addClass('label label-important');
        message = data.responseText || data.statusText;
        return $row.children().last().append($label.text(message));
      });
    };


    return $table.on('focusout', 'tr', function() {
      console.log('save');
      return saveRow($(this));
    });
  });
}).call(this);
