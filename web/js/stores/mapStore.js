var Reflux = require('reflux');
var $ = require('jquery');
var MapActions = require('../actions/mapActions.js');

var results = [];

var MapStore = Reflux.createStore({
    listenables: MapActions,

    onFindGridInformations: function () {
        $.ajax({
            beforeSend: function(xhrObj){
                xhrObj.setRequestHeader("Content-Type","application/json");
                xhrObj.setRequestHeader("Accept","application/json");
            },
            url: 'http://localhost:8080/rest/game/grid',
            type: 'GET',
            context:this,
            success: function(data) {
                if (data) {
                    console.log("Result OKK");
                    results = results.concat(data);
                    this.trigger(results);
                    /*console.log(data);
                     console.log(results);*/
                }else{
                    console.log("Result KO");
                    console.log(data);
                }
            }
        });
    }
});

module.exports = MapStore;