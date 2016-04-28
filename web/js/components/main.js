var React = require('react');
var Reflux = require('reflux');
var Grid = require('react-bootstrap').Grid;
var Row = require('react-bootstrap').Row;
var Col = require('react-bootstrap').Col;
var UnitGridGroup = require('./grid/unitGridGroup.js');

var MockData = require('./grid/mockData.js');
var MapAction = require('../actions/mapActions.js');
var MapStore = require('../stores/mapStore.js');


var Main = React.createClass({

    mixins: [Reflux.connect(MapStore, "store")],
    getInitialState: function () {
        MapAction.findGridInformations();
    },

    render: function () {
        if ( !this.state.store ) {
            return (
                <Grid>
                    <Row>
                        <Col sm={10} smOffset={1} md={10} mdOffset={1}>
                            <img className=" loaderGif" src="./images/loading.gif" alt="loading" />
                        </Col>
                    </Row>
                </Grid>
            )
        }

        console.log(this.state.store);

        return (
            <Grid className="mainGrid">
                <Row>
                    <Col sm={10} smOffset={1} md={10} mdOffset={1}>
                        <h1>TREASURE HUNTER GAME</h1>
                        <p className="descriptionGrid">Enjoy your game, but remember the house always win ;-)</p>
                        <UnitGridGroup gridInformation={this.state.store} />
                    </Col>
                </Row>
            </Grid>
        );
    }
});


module.exports = Main;