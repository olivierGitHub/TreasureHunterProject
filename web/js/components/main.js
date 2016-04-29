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
        return {
            sequence:''
        };
    },

    handleClick:function(event){
        event.preventDefault();
        MapAction.playSequence(this.state.sequence);
        this.setState({sequence: ''});
    },
    _onChangeSequence:function(e){
        this.setState({sequence: e.target.value});
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
                    <Col sm={6} smOffset={1} md={6} mdOffset={1}>
                        <h1>TREASURE HUNTER GAME</h1>
                        <p className="descriptionGrid">Enjoy your game, but remember the house always win ;-)</p>
                        <UnitGridGroup gridInformation={this.state.store} />
                    </Col>
                    <Col sm={4} smOffset={1} md={4} mdOffset={1}>
                        <p className="gameInstruction">Type a player (John) sequence here</p>
                        <p>ex: John 1-1 E AADADAGA</p>
                        <form onSubmit={this.handleClick}>
                            <input type="text" placeholder="sequence" value={this.state.sequence} onChange={this._onChangeSequence}  />
                            <button type="submit" >submit</button>
                        </form>
                        <p className="gameLegend">Legend: </p>
                        <p className="colorPlayer">PLAYER</p>
                        <p className="colorMountain">MOUNTAIN</p>
                        <p className="colorTreasure">TREASURE</p>
                    </Col>
                </Row>
            </Grid>
        );
    }
});


module.exports = Main;