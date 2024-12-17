import React, { useEffect, useState } from 'react';
import { View, Text, FlatList, TextInput, Button, StyleSheet, Alert } from 'react-native';
import axios from 'axios';

const App = () => {
    const [transactions, setTransactions] = useState([]);
    const [description, setDescription] = useState('');
    const [amount, setAmount] = useState('');

    // Fetch transactions from the backend
    const fetchTransactions = async () => {
        try {
            const response = await axios.get('http://localhost:8080/api/transactions');
            setTransactions(response.data);
        } catch (error) {
            console.error('Error fetching transactions:', error);
            Alert.alert('Error', 'Failed to fetch transactions.');
        }
    };

    // Add a new transaction
    const addTransaction = async () => {
        if (!description || !amount) {
            Alert.alert('Error', 'Please enter both description and amount.');
            return;
        }

        if (isNaN(amount)) {
            Alert.alert('Error', 'Amount must be a valid number.');
            return;
        }

        try {
            const newTransaction = { description, amount: parseFloat(amount) };
            await axios.post('http://localhost:8080/api/transactions', newTransaction);
            setDescription('');
            setAmount('');
            fetchTransactions();
        } catch (error) {
            console.error('Error adding transaction:', error);
            Alert.alert('Error', 'Failed to add transaction.');
        }

        <Button title="Refresh Transactions" onPress={fetchTransactions} />

    };
    };

    useEffect(() => {
        fetchTransactions();
    }, []);

    // Calculate total balance
    const totalBalance = transactions.reduce((sum, item) => sum + item.amount, 0);

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Budget Tracker</Text>

            <Text style={styles.balance}>Total Balance: {totalBalance.toFixed(2)} SEK</Text>

            <FlatList
                data={transactions}
                keyExtractor={(item) => item.id.toString()}
                renderItem={({ item }) => (
                    <View style={styles.transactionCard}>
                        <Text style={styles.transactionDescription}>{item.description}</Text>
                        <Text style={styles.transactionAmount}>{item.amount.toFixed(2)} SEK</Text>
                    </View>
                )}
            />

            <TextInput
                style={styles.input}
                placeholder="Description"
                value={description}
                onChangeText={setDescription}
            />
            <TextInput
                style={styles.input}
                placeholder="Amount"
                keyboardType="numeric"
                value={amount}
                onChangeText={setAmount}
            />
            <Button title="Add Transaction" onPress={addTransaction} />
        </View>
    );
    {
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 20,
        backgroundColor: '#f4f4f4',
    },
    title: {
        fontSize: 28,
        fontWeight: 'bold',
        marginBottom: 10,
        color: '#333',
        textAlign: 'center',
    },
    balance: {
        fontSize: 20,
        fontWeight: 'bold',
        marginBottom: 20,
        color: '#2a9d8f',
        textAlign: 'center',
    },
    transactionCard: {
        backgroundColor: '#fff',
        padding: 15,
        borderRadius: 10,
        marginVertical: 5,
        elevation: 2,
        flexDirection: 'row',
        justifyContent: 'space-between',
    },
    transactionDescription: {
        fontSize: 16,
        color: '#333',
    },
    transactionAmount: {
        fontSize: 16,
        fontWeight: 'bold',
        color: '#e76f51',
    },
    input: {
        backgroundColor: '#fff',
        padding: 10,
        borderRadius: 8,
        marginVertical: 10,
        borderWidth: 1,
        borderColor: '#ccc',
    },
});

export default App;
