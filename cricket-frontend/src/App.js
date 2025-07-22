import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './App.css';

const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8081';
const PLAYER_ENDPOINT = '/player';

function App() {
    const [players, setPlayers] = useState([]);
    const [loading, setLoading] = useState(false);
    const [errMsg, setErrMsg] = useState('');

    const [name, setName] = useState('');
    const [sr, setSr] = useState('');
    const [runs, setRuns] = useState('');

    useEffect(() => {
        fetchPlayers();
    }, []);

    const fetchPlayers = async (query = {}) => {
        setLoading(true);
        setErrMsg('');
        try {
            const resp = await axios.get(`${API_BASE_URL}${PLAYER_ENDPOINT}`, { params: query });
            setPlayers(resp.data || []);
        } catch (err) {
            console.error('Error fetching players:', err);
            setErrMsg('Failed to load players. Check backend or network.');
            setPlayers([]);
        } finally {
            setLoading(false);
        }
    };

    const onSearch = (e) => {
        e.preventDefault();
        const params = {};
        if (name.trim()) params.name = name.trim();
        if (sr.trim()) params.sr = Number(sr);
        if (runs.trim()) params.runs = Number(runs);

        fetchPlayers(params);
    };

    const onReset = () => {
        setName('');
        setSr('');
        setRuns('');
        fetchPlayers();
    };

    // Helper: Replace null/undefined with 0
    const val = (v) => v ?? 0;

    return (
        <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
            <h1>Cricket Player Stats</h1>

            <form onSubmit={onSearch} style={{ marginBottom: '16px', display: 'flex', gap: '8px', flexWrap: 'wrap' }}>
                <input
                    type="text"
                    placeholder="Search by name"
                    value={name}
                    onChange={e => setName(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="Min Strike Rate"
                    value={sr}
                    onChange={e => setSr(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="Min Runs"
                    value={runs}
                    onChange={e => setRuns(e.target.value)}
                />
                <button type="submit">Search</button>
                <button type="button" onClick={onReset}>Reset</button>
            </form>

            {loading && <p>Loading...</p>}
            {errMsg && <p style={{ color: 'red' }}>{errMsg}</p>}

            {!loading && !errMsg && (
                <>
                    <p>{players.length} player{players.length === 1 ? '' : 's'} found.</p>
                    {players.length === 0 ? (
                        <p>No players found.</p>
                    ) : (
                        <table border="1" cellPadding="10">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Matches</th>
                                <th>Innings</th>
                                <th>Not Outs</th>
                                <th>Runs</th>
                                <th>HS</th>
                                <th>Avg</th>
                                <th>Balls Faced</th>
                                <th>SR</th>
                                <th>100s</th>
                                <th>50s</th>
                                <th>0s</th>
                                <th>4s</th>
                                <th>6s</th>
                            </tr>
                            </thead>
                            <tbody>
                            {players.map(player => (
                                <tr key={player.id}>
                                    <td>{val(player.id)}</td>
                                    <td>{player.name || 'Unknown'}</td>
                                    <td>{val(player.matches)}</td>
                                    <td>{val(player.inns)}</td>
                                    <td>{val(player.no)}</td>
                                    <td>{val(player.runs)}</td>
                                    <td>{val(player.hs)}</td>
                                    <td>{val(player.avg)}</td>
                                    <td>{val(player.bf)}</td>
                                    <td>{val(player.sr)}</td>
                                    <td>{val(player.hundreds)}</td>
                                    <td>{val(player.fifties)}</td>
                                    <td>{val(player.zeroes)}</td>
                                    <td>{val(player.fours)}</td>
                                    <td>{val(player.sixes)}</td>
                                </tr>
                            ))}
                            </tbody>
                        </table>
                    )}
                </>
            )}
        </div>
    );
}

export default App;
