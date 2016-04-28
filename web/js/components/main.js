var React = require('react');
var Grid = require('react-bootstrap').Grid;
var Row = require('react-bootstrap').Row;
var Col = require('react-bootstrap').Col;
var UnitGridGroup = require('./grid/unitGridGroup.js');


var Main = React.createClass({
    render: function () {

        var gridInformation = [
            {position:'1-1',typeUnitGrid:'blankUnit'},
            {position:'1-2',typeUnitGrid:'treasureUnit'},
            {position:'1-3',typeUnitGrid:'mountainUnit'},
            {position:'1-4',typeUnitGrid:'blankUnit'},
            {position:'1-5',typeUnitGrid:'blankUnit'},
            {position:'1-6',typeUnitGrid:'treasureUnit'},
            {position:'2-1',typeUnitGrid:'blankUnit'},
            {position:'2-2',typeUnitGrid:'treasureUnit'},
            {position:'2-3',typeUnitGrid:'blankUnit'},
            {position:'2-4',typeUnitGrid:'blankUnit'},
            {position:'2-5',typeUnitGrid:'blankUnit'},
            {position:'2-6',typeUnitGrid:'blankUnit'},
            {position:'3-1',typeUnitGrid:'blankUnit'},
            {position:'3-2',typeUnitGrid:'blankUnit'},
            {position:'3-3',typeUnitGrid:'mountainUnit'},
            {position:'3-4',typeUnitGrid:'blankUnit'},
            {position:'3-5',typeUnitGrid:'blankUnit'},
            {position:'3-6',typeUnitGrid:'explorerUnit'},
            {position:'4-1',typeUnitGrid:'blankUnit'},
            {position:'4-2',typeUnitGrid:'treasureUnit'},
            {position:'4-3',typeUnitGrid:'mountainUnit'},
            {position:'4-4',typeUnitGrid:'blankUnit'},
            {position:'4-5',typeUnitGrid:'blankUnit'},
            {position:'4-6',typeUnitGrid:'treasureUnit'},
            {position:'5-1',typeUnitGrid:'blankUnit'},
            {position:'5-2',typeUnitGrid:'treasureUnit'},
            {position:'5-3',typeUnitGrid:'blankUnit'},
            {position:'5-4',typeUnitGrid:'blankUnit'},
            {position:'5-5',typeUnitGrid:'blankUnit'},
            {position:'5-6',typeUnitGrid:'blankUnit'}
        ];


        return (
            <Grid>
                <Row className="">
                    <Col sm={10} smOffset={1} md={10} mdOffset={1}>
                        <h1>MAIN</h1>
                        <p>enjoy your game, it's just a game</p>
                        <UnitGridGroup gridInformation={gridInformation} />
                    </Col>
                </Row>
            </Grid>
        );
    }
});


module.exports = Main;